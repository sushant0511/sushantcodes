package com.example.TestCodeSpringBoot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {

	@Autowired
	ProductService service;
	
	@RequestMapping("/")
	public String show(Model model)   //console 
	{
		List<Product> list=service.showProduct();
		for(Product product:list)
		{
			System.out.println(product.getName()+" "+product.getCost());
		}
		model.addAttribute("list", list);
		return "index";
		
	}
	@RequestMapping("/addData")
	public String openAddDataPage(Model model)
	{
	Product product=new Product();
	model.addAttribute("product",product);
	return "addNewData";
	}
	
	@RequestMapping(value="/addDataweb", method=RequestMethod.POST)
	public String addingDatta(@ModelAttribute("product") Product prodcut)
	{
	 service.myMethod(prodcut);
	 System.out.println("Data is inserted in this ");
	return "redirect:/";
	}
	
}
