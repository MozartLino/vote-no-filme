package br.com.lino.votenofilme.application.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.resource.ResourceMethod;
import br.com.caelum.vraptor.view.Results;

@Intercepts(after = {})
public class AjaxErrorInterceptor implements Interceptor {

	private Logger logger = Logger.getLogger(AjaxErrorInterceptor.class);
	private HttpServletRequest request;
	private Result result;

	public AjaxErrorInterceptor(HttpServletRequest request, Result result) {
		this.request = request;
		this.result = result;
	}

	public void intercept(InterceptorStack stack, ResourceMethod method, Object resourceInstance) throws InterceptionException {
		try {
			stack.next(method, resourceInstance);
		} catch (Exception e) {
			logger.error(e);
			result.use(Results.http()).body("Ocorreu um erro na aplicação");
		}
	}

	public boolean accepts(ResourceMethod method) {
		return request.getHeader("accept").contains("application/json");
	}

}