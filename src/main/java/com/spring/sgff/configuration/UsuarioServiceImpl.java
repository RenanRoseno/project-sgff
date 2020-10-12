package com.spring.sgff.configuration;

import com.spring.sgff.models.Usuario;
import com.spring.sgff.repository.UsuarioRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class UsuarioServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository ur;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Usuario usuario = ur.getUserByUsername(login);

        if (usuario == null) {
            throw new UsernameNotFoundException("Usuário Inválido");
        }

        return new User(usuario.getLogin(), usuario.getSenha(), true, true, true, true, usuario.getAuthorities());
    }

}
