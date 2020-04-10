package com.decode;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductsAction 
{
	
	@Autowired
	ProductDao dao;
	
	@RequestMapping("addProduct")
	public String setProduct()
	{
		return "addpro.jsp";
	}
	
	@RequestMapping("addProductDetails")
	public String setProductProperty(@RequestParam("pcode")int pcode,@RequestParam("pname")String name,@RequestParam("pprice")int price )
	{
		ProductBean bean=new ProductBean();
		bean.setProductCode(pcode);
		bean.setProductName(name);
		bean.setProductPrice(price);
		
		
		dao.setProducts(bean);
		
		return "addprosuccess.jsp";
	}
	
	@RequestMapping("delpro")
	public String deletecode()
	{
		return "deletepro.jsp";
	}
	
	@RequestMapping("deletePro")
	public String deleteProduct(@RequestParam("pcode")int pcode)
	{
		ProductBean bean=new ProductBean();
		bean.setProductCode(pcode);
		dao.deleteProduct(bean);
		
		return "deletesuccess.jsp";
	}
	
	@RequestMapping("showProducts")
	public ModelAndView showProducts()
	{
		List prodata=dao.showproducts();
		ModelAndView view=new ModelAndView();
		view.setViewName("allproduct.jsp");
		view.addObject("data", prodata);
		System.out.println(prodata);
		return view;
	}
}
