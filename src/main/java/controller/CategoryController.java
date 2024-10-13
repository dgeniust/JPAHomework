package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;
import java.util.List;

import entity.Category;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import service.ICategoryService;
import service.impl.CategoryService;

@SuppressWarnings("serial")
@WebServlet (urlPatterns = {"/admin/categories", "/admin/category/edit", "/admin/category/update"
		,"/admin/category/insert", "/admin/category/add", "/admin/category/delete", "/admin/category/search"})
public class CategoryController extends HttpServlet{
	public ICategoryService cateService = new CategoryService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String url = req.getRequestURI();
		if(url.contains("categories")) {
			List<Category> list = cateService.findAll();
			req.setAttribute("listcate", list);
			req.getRequestDispatcher("/views/admin/category-list.jsp").forward(req, resp);
		}
		else if(url.contains("/admin/category/edit")){
			int id = Integer.parseInt(req.getParameter("id"));
			Category category = cateService.findById(id);
			req.setAttribute("cate", category);
			req.getRequestDispatcher("/views/admin/category-edit.jsp").forward(req, resp);
		}
		else if(url.contains("/admin/category/add")){
			req.getRequestDispatcher("/views/admin/category-add.jsp").forward(req, resp);
		}
		else if(url.contains("/admin/category/delete")){
			int id = Integer.parseInt(req.getParameter("id"));
			System.out.println("test id: ");
			System.out.println(id);
			Category category = cateService.findById(id);
			try {
				cateService.delete(category.getCategoryId());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resp.sendRedirect(req.getContextPath() + "/admin/categories");
		}
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String url = req.getRequestURI();
		if(url.contains("/admin/category/update")) {
			int categoryid = Integer.parseInt(req.getParameter("categoryid"));
			String categoryname = req.getParameter("categoryname");
			int status = Integer.parseInt(req.getParameter("status"));
			String images = uploadFileImage(req);
			
			Category category = new Category();
			category.setCategoryId(categoryid);
			category.setCategoryname(categoryname);
			category.setImages(images);
			category.setStatus(status);
			
			cateService.update(category);
			resp.sendRedirect(req.getContextPath() + "/admin/categories");
			
		}
		else if(url.contains("/admin/category/insert")) {
			String categoryname = req.getParameter("categoryname");
			int status = Integer.parseInt(req.getParameter("status"));
			String images = uploadFileImage(req);
			Category category = new Category();
			category.setCategoryname(categoryname);
			category.setImages(images);
			category.setStatus(status);
			System.out.println("test 1");
			System.out.println(categoryname);
			System.out.println(images);
			System.out.println(status);
			cateService.insert(category);
			resp.sendRedirect(req.getContextPath() + "/admin/categories");
		}
		else if(url.contains("/admin/category/search")) {
			System.out.println("test find: ");
			String name = req.getParameter("catesearch");
			System.out.println("test catename: ");
			System.out.println(name);
			List<Category> listResult = cateService.findByCategoryname(name);
			req.setAttribute("listResult", listResult);
			req.getRequestDispatcher("/views/admin/category-find.jsp").forward(req,resp);
		}
	}
	private String getFileName(Part part) {
		return part.getSubmittedFileName();
	}
	public static String encodeImage(String path) {
		byte[] fileContent;
		try {
			fileContent = Files.readAllBytes(new File(path).toPath());
			return Base64.getEncoder().encodeToString(fileContent);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public String uploadFileImage(HttpServletRequest request) {
		String uploadPath = getServletContext().getRealPath("") + Constants.UPLOAD_DIRECTORY;
		File uploadDir = new File(uploadPath);

		if (!uploadDir.exists())
			uploadDir.mkdir();
		try {
			String fileName = "";
			Part part = request.getPart("images");
			fileName = getFileName(part);
			System.out.println("đây là filename trong upload:"+fileName);
			if (fileName==null || fileName.length() <= 0)
				return null;
			System.out.println("write " + fileName+"|");
			System.out.println(uploadPath);
			part.write(uploadPath + fileName);
			request.setAttribute("message", "File " + fileName + " has uploaded successfully!");

			return fileName;

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "There was an error: " + e.getMessage());

		}
		return null;
	}
}