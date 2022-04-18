/*package cybersoft.javabackend.ecommerce.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import cybersoft.javabackend.ecommerce.role.model.Role;
import cybersoft.javabackend.ecommerce.role.repository.RoleRepository;
import cybersoft.javabackend.ecommerce.user.model.User;
import cybersoft.javabackend.ecommerce.user.repository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class GoogleOAuth2SuccessHandler implements AuthenticationSuccessHandler {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        OAuth2AuthenticationToken token = (OAuth2AuthenticationToken) authentication;
        String email = token.getPrincipal().getAttributes().get("email").toString();
        if(userRepository.findByEmail(email).isPresent()){

        }else {
            User user = new User();
            user.setFirst_name(token.getPrincipal().getAttributes().get("given_name").toString());
            user.setLast_name(token.getPrincipal().getAttributes().get("family_name").toString());
            user.setEmail(email);
            user.setPassword(bCryptPasswordEncoder.encode("1"));
            List<Role> roles = new ArrayList<>();
            roles.add(roleRepository.findById((long) 2).get());
            user.setRoles(roles);
            userRepository.save(user);
        }

        redirectStrategy.sendRedirect(httpServletRequest, httpServletResponse, "/");
    }


}
*/
