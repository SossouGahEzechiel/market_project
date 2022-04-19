package com.example.deb_projet.Error;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyErrorController implements ErrorController {

  @RequestMapping("/error")
  public String handleError(HttpServletRequest request,Model model) {
    Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

    if (status != null) {
      Integer statusCode = Integer.valueOf(status.toString());

      if (statusCode == HttpStatus.NOT_FOUND.value()) {
        model.addAttribute("title", "Erreur 404");
        return "errors/error-404";
      } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
        model.addAttribute("title", "Erreur 500");
        return "errors/error-500";
      } else if (statusCode == HttpStatus.FORBIDDEN.value()) {
        model.addAttribute("title", "Erreur 403");
        return "errors/error-403";
      } else if (statusCode == HttpStatus.UNAUTHORIZED.value()) {
        model.addAttribute("title", "Erreur 401");
        return "errors/error-401";
      }
    }
    return "errors/error";
  }
}
