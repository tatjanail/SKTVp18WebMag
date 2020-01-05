/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entity.Buyer;
import entity.Car;
import entity.History;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.BuyerFacade;
import session.CarFacade;
import session.HistoryFacade;

/**
 *
 * @author user
 */
@WebServlet(name = "MyServlet", urlPatterns = {
    "/showLogin",
    "/login",
    "/newCar",
    "/listCars",
    "/addCar",
    "/newBuyer",
    "/addBuyer",
    "/listBuyers",
    "/showTakeOnCar",
    "/takeOnCar"
    //"/showReturnBook",
    //"/returnOnBook"
        
})
public class MyServlet extends HttpServlet {
@EJB CarFacade carFacade;
@EJB BuyerFacade buyerFacade;
@EJB HistoryFacade historyFacade;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String path = request.getServletPath();
        switch (path) {
            case "/newCar":
                request.getRequestDispatcher("/WEB-INF/newCar.jsp")
                        .forward(request, response);
                break;
            case "/addCar":
                String marka = request.getParameter("marka");
                String model = request.getParameter("model");
                String year = request.getParameter("year");
                String price = request.getParameter("price");
                String quantity = request.getParameter("quantity");
                Car car = new Car(marka, model, Integer.parseInt(year), Integer.parseInt(price), Integer.parseInt(quantity));
                carFacade.create(car);
                request.setAttribute("info", "Машина внесена в базу");
                request.setAttribute("car", car);
                request.getRequestDispatcher("/index.jsp")
                        .forward(request, response);
                break;
            case "/listCars":
                List<Car> listCars = carFacade.findAll();
                request.setAttribute("listCars", listCars);
                request.getRequestDispatcher("/listCars.jsp")
                        .forward(request, response);
                break;
            case "/newBuyer":
                request.getRequestDispatcher("/WEB-INF/newBuyer.jsp")
                        .forward(request, response);
                break;
            case "/addBuyer":
                String name = request.getParameter("name");
                String lastname = request.getParameter("lastname");
                String email = request.getParameter("email");
                String money = request.getParameter("money");
                Buyer buyer = new Buyer(name, lastname, email, Integer.parseInt(money));
                buyerFacade.create(buyer);
                request.setAttribute("info", "Покупатель внесён в базу");
                request.getRequestDispatcher("/index.jsp")
                        .forward(request, response);
                break;
            case "/listBuyers":    
                List<Buyer> listBuyers = buyerFacade.findAll();
                request.setAttribute("listBuyers", listBuyers);
                request.getRequestDispatcher("/listBuyers.jsp")
                        .forward(request, response);
            case "/showLogin":
                request.getRequestDispatcher("/WEB-INF/showLogin.jsp")
                        .forward(request, response);
                break;
            case "/login":
                String login = request.getParameter("login");
                String password = request.getParameter("password");
                if("Olga".equals(login) && "123123".equals(password)){
                    request.setAttribute("info", "Привет, "+login+"!");
                }else{
                    request.setAttribute("info", "Неправильный логин или пароль!");
                }
                request.getRequestDispatcher("/index.jsp")
                        .forward(request, response);
                break;
            case "/showTakeOnCar":
                listCars=carFacade.findAll();
                listBuyers=buyerFacade.findAll();
                request.setAttribute("listCars", listCars);
                request.setAttribute("listBuyers", listBuyers);
                request.getRequestDispatcher("/WEB-INF/showTakeOnCar.jsp")
                        .forward(request, response);
                break;
            case "/takeOnCar":
                String carId = request.getParameter("carId");
                String buyerId = request.getParameter("buyerId");
                car = carFacade.find(Long.parseLong(carId));
                buyer = buyerFacade.find(Long.parseLong(buyerId));
                
                if(car.getCount()>0){
                car.setCount(car.getCount()-1);
                carFacade.edit(car);
                buyer.setMoney(buyer.getMoney() - car.getPrice());
                buyerFacade.edit(buyer);
                
             
                request.setAttribute("info",
                        "Машина \""
                        +car.getMarka()
                        +" "+car.getModel()
                        +"\" продана покупателю "
                        +buyer.getName()
                        +" "+buyer.getLastname()
                );
                
                
                 
                History history = new History();
                history.setCar(car);
                history.setBuyer(buyer);
                history.setTakeOn(new Date());
historyFacade.create(history);

                }else{
                request.setAttribute("info", "Все машины проданы");
            }
//              if (car.getPrice() > buyer.getMoney()) {
//            request.setAttribute("info","У клиента " + buyer.getName() + " " + buyer.getLastname() + " не хватает денег. Пополнить счёт!");        
     
            
            
           request.getRequestDispatcher("/index.jsp").forward(request, response);
                
//              
//                History history = new History();
//                history.setCar(car);
//                history.setBuyer(buyer);
//                history.setTakeOn(new Date());
//                historyFacade.create(history);
            
            
            
//                
//                buyer.setMoney(buyer.getMoney() - car.getPrice());
//        car.setCount(car.getCount() - 1);
//        car.setQuantity(car.getCount());
//        historyFacade.create(history);
  
    



//                buyer.setMoney(buyer.getMoney() - car.getPrice());
//                history.setBuyer(buyer);
//                car.setCount(car.getCount() - 1);
//                history.setCar(car);
//                
//                history.setTakeOn(new Date());
                
//                
                break;
        }
        } 
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
