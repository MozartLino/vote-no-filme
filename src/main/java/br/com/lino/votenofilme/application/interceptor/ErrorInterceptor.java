package br.com.lino.votenofilme.application.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.resource.ResourceMethod;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.lino.votenofilme.application.controller.UserController;

@Intercepts(after = {})
public class ErrorInterceptor implements Interceptor {

	private Logger logger = Logger.getLogger(ErrorInterceptor.class);
	private HttpServletRequest request;
	private Validator validator;

	public ErrorInterceptor(HttpServletRequest request, Validator validator) {
		this.request = request;
		this.validator = validator;
	}

	public void intercept(InterceptorStack stack, ResourceMethod method, Object resourceInstance) throws InterceptionException {
		try {
			stack.next(method, resourceInstance);
		} catch (Exception e) {
			logger.error(e);
			validator.add(new ValidationMessage("Ocorreu um erro na aplicação", "error"));
			validator.onErrorRedirectTo(UserController.class).error();
		}
	}

	public boolean accepts(ResourceMethod method) {
		return !request.getHeader("accept").contains("application/json");
	}

}