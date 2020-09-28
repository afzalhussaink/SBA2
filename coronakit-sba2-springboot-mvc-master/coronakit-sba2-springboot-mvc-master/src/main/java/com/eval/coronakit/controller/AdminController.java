package com.eval.coronakit.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.eval.coronakit.entity.ProductMaster;
import com.eval.coronakit.exception.ProductMasterException;
import com.eval.coronakit.service.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	ProductService productService;
	
	@GetMapping("/home")
	public String home() {
		return "admin-home";
	}
	
	@RequestMapping("/product-entry")
	public ModelAndView productEntry(@ModelAttribute("product") @Valid ProductMaster product, BindingResult result) throws ProductMasterException {
		ModelAndView mv = null;
		
		if(result.hasErrors()) {
			mv = new ModelAndView("add-new-item","product",product);
			mv.addObject("isNew", true);
		}else {
			productService.addNewProduct(product);
			mv= new ModelAndView("show-all-item-admin","products", productService.getAllProducts());
			mv.addObject("msg","Product is added Successfully!");
		}
		return mv;
		//return "add-new-item";
	}
	
	@PostMapping("/product-save")
	public ModelAndView productSave(@ModelAttribute ProductMaster product, BindingResult result ) throws ProductMasterException {
		ModelAndView mv = null;
		
		if(result.hasErrors()) {
			mv = new ModelAndView("add-new-item","product",product);
			mv.addObject("isNew", false);
		}else {
			productService.saveProduct(product);
			mv= new ModelAndView("show-all-item-admin","products", productService.getAllProducts());
			mv.addObject("msg","Product is saved Successfully!");
		}
		return mv;
	}
	

	@RequestMapping("/product-list")
	public ModelAndView productList(Model model) {
		return new ModelAndView("show-all-item-admin", "products", productService.getAllProducts());

	}
	
	@GetMapping("/product-delete/{productId}")
	public ModelAndView productDelete(@PathVariable("productId") int productId) throws ProductMasterException {
		productService.deleteProduct(productId);
		ModelAndView mv= new ModelAndView("show-all-item-admin","products", productService.getAllProducts());
		mv.addObject("msg","Product is deleted Successfully!");
		return mv;
	}
	
	@GetMapping("/product-edit/{productId}")
	public ModelAndView productEdit(@PathVariable("productId") int productId) {
		ProductMaster product = productService.getProductById(productId);
		ModelAndView mv = new ModelAndView("add-new-item","product",product);
		mv.addObject("isNew",false);
		return mv;
	}
	
}
