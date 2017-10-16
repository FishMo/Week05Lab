/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 709317
 */
public class ShoppingListServlet extends HttpServlet {

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
  
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        String action = request.getParameter("action");


        if (action != null && action.equals("logout")) 
        {
            session.removeAttribute("name");
            session.invalidate();
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }
          
         
        if (username != null)
        {
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        }
        else
        {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }    
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        ArrayList<String> itemlist = (ArrayList<String>)session.getAttribute("itemlist");
        String url ="/WEB-INF/shoppingList.jsp";
        
        if(itemlist==null)
        {
            itemlist = new ArrayList<String>();
        }
        
        switch (action)
        {

            case "register":
                String username = request.getParameter("username");
                if(username==null || username.isEmpty())
                {
                    request.setAttribute("message","Please Enter a user name!");
                    url="/WEB-INF/register.jsp";
                }
                else
                {
                    session.setAttribute("username", username);
                    session.setAttribute("itemlist", itemlist);
                    url="/WEB-INF/shoppingList.jsp";
                }
                break;
            
            case "logout":
                session.invalidate();
                url="/WEB-INF/register.jsp";
                break;
                     
            case "add":
                String item = request.getParameter("item");
                if(item==null || item.isEmpty())
                {
                    request.setAttribute("message", "Please add an item!");
                }
                else
                {
                    itemlist.add(item);
                    url="/WEB-INF/shoppingList.jsp";
                }
                break;
                
            case "delete":
                String index =request.getParameter("itemname");               
                if (index == null || index.trim().isEmpty()) 
                {
                    request.setAttribute("message", "Please select an item! ");
                }
                else
                {
                    itemlist.remove(Integer.parseInt(index));
                    url="/WEB-INF/shoppingList.jsp" ;
                }
                break;
                
            default:
                if(session.getAttribute("username")==null)
                    url="/WEB-INF/register.jsp";
                
                else
                    url="/WEB-INF/shoppingList.jsp";
                
        }

        getServletContext().getRequestDispatcher(url).forward(request, response);

        
    }


}
