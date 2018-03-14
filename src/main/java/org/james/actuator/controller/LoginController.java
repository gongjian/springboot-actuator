package org.james.actuator.controller;

import org.james.actuator.entity.Msg;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("/")
	public String index(Model model) {
		Msg msg = new Msg("测试标题", "测试内容", "只对管理员显示信息");
		model.addAttribute("msg", msg);

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			UserDetails ud = (UserDetails) principal;
			System.out.println(ud.getUsername());
			System.out.println(ud.getAuthorities());
		}

		return "index";
	}

}
