package BehaviouralPatterns;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

// check code for Filters in Servlet
 class CustomFilter implements Filter {

    public void doFilter(
      ServletRequest request,
      ServletResponse response,
      FilterChain chain)
      throws IOException, ServletException {

        // process the request

        // pass the request (i.e. the command) along the filter chain
        chain.doFilter(request, response);
    }
}