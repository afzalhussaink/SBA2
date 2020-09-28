package com.eval.coronakit.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.eval.coronakit.entity.CoronaKit;
import com.eval.coronakit.entity.KitDetail;
import com.eval.coronakit.entity.ProductMaster;
import com.eval.coronakit.exception.ProductMasterException;
import com.eval.coronakit.service.CoronaKitService;
import com.eval.coronakit.service.KitDetailService;
import com.eval.coronakit.service.ProductService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CoronaKitService coronaKitService;
	
	@Autowired
	KitDetailService kitDetailService;
	
	@RequestMapping("/home")
	public String home() {
		return "user-home";
	}
	
	@RequestMapping("/show-kit")
	public ModelAndView showKit(HttpSession session) {
		ModelAndView mv = new ModelAndView("show-cart","cartProducts",session.getAttribute("cartProducts"));
		return mv;
	}

	@RequestMapping("/show-list")
	public ModelAndView showList(Model model) {
		return new ModelAndView("show-all-item-user", "products", productService.getAllProducts());
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/add-to-cart/{productId}")
	public ModelAndView showKit(@PathVariable("productId") int productId,HttpSession session) {
		
		List<ProductMaster> selectedProducts;
		ProductMaster product;
		product = productService.getProductById(productId);
		selectedProducts = (List<ProductMaster>) session.getAttribute("cartProducts");
		if(selectedProducts==null) {
			selectedProducts = new ArrayList<ProductMaster>();
		}
		selectedProducts.add(product);
		session.setAttribute("cartProducts", selectedProducts);
		ModelAndView mv = new ModelAndView("show-all-item-user","products",productService.getAllProducts());
		mv.addObject("msg", product.getProductName()+" added to Corona-Kit!");
		System.out.println("selectedProducts:"+selectedProducts);
		return mv;
	}
	
	@RequestMapping("/checkout")
	public String checkout(HttpServletRequest request) {
		HttpSession session  = request.getSession();
		List<KitDetail> kitItems = new ArrayList<KitDetail>();
		CoronaKit coronakit = (CoronaKit) session.getAttribute("coronakit");
		if(coronakit==null) {
			coronakit = new CoronaKit();
		}
		String[] selectedItems = request.getParameterValues("productId");
		String[] givenQuantity = request.getParameterValues("quantity");
		int totalAmount = 0;
		int i =0;
		for (String item:selectedItems) {
			KitDetail kitDetail = new KitDetail();
			kitDetail.setProductId(Integer.parseInt(item));
			ProductMaster product = productService.getProductById(Integer.parseInt(item));
			//kitDetail.setProductName(product.getProductName());
			kitDetail.setQuantity(Integer.parseInt(givenQuantity[i]));
			int amount =  product.getCost()*Integer.parseInt(givenQuantity[i]);
			kitDetail.setAmount(amount);
			i++;
			totalAmount = totalAmount+amount;
			kitDetailService.addKitItem(kitDetail);
			kitItems.add(kitDetail);
		}
		coronakit.setTotalAmount(totalAmount);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("date:"+format.format(new Date()));
		coronakit.setOrderDate(format.format(new Date()));
		session.setAttribute("kitItems", kitItems);
		request.setAttribute("total", totalAmount);
		session.setAttribute("coronakit", coronakit);
		return "checkout-address";
	}
	
	@RequestMapping("/finalize")
	public ModelAndView finalizeOrder(HttpServletRequest request,HttpSession session) throws ProductMasterException {
		CoronaKit coronaKit = (CoronaKit) session.getAttribute("coronakit");
		coronaKit.setDeliveryAddress((String) request.getParameter("address"));
		coronaKitService.saveKit(coronaKit);
		ModelAndView mv = new ModelAndView("show-summary","coronakit",coronaKit);
		return mv;
	}
	
	@RequestMapping("/delete/{itemId}")
	public ModelAndView deleteItem(@PathVariable("itemId") int itemId, HttpSession session) {
		
		List<ProductMaster>selectedProducts = (List<ProductMaster>) session.getAttribute("cartProducts");
		Iterator itr = selectedProducts.iterator();
		while(itr.hasNext()) {
			ProductMaster product = (ProductMaster) itr.next();
			if(product.getId()==itemId) {
				itr.remove();
			}
		}
		session.setAttribute("cartProducts",selectedProducts);
		ModelAndView mv = new ModelAndView("show-cart","cartProducts",selectedProducts);
		return mv;
	}
}
