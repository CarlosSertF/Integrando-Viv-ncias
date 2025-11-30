package br.com.integrandovivencias.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.integrandovivencias.api.dto.LoginRequestDTO;
import br.com.integrandovivencias.api.dto.UsuarioRequestDTO;
import br.com.integrandovivencias.api.dto.UsuarioResponseDTO;
import br.com.integrandovivencias.api.model.Usuario;
import br.com.integrandovivencias.api.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    // Método de Cadastro
    public UsuarioResponseDTO cadastrar(UsuarioRequestDTO dados) {
        // Verifica se email já existe
        if (repository.findByEmail(dados.email()).isPresent()) {
            throw new RuntimeException("Email já cadastrado!");
        }

        // Cria o usuário (Aqui entraria a criptografia BCrypt no futuro)
        Usuario novoUsuario = new Usuario(
            dados.email(),
            dados.nome(),
            dados.cargo(),
            dados.senha() 
        );

        repository.save(novoUsuario);
        return new UsuarioResponseDTO(novoUsuario);
    }

    // Método de Login (RF02)
    public UsuarioResponseDTO logar(LoginRequestDTO dados) {
        // 1. Busca pelo email
        Usuario usuario = repository.findByEmail(dados.email())
                .orElseThrow(() -> new RuntimeException("Usuário ou senha inválidos")); // Mensagem genérica por segurança

        // 2. Verifica a senha (Comparação simples para o MVP)
        if (!usuario.getSenha().equals(dados.senha())) {
            throw new RuntimeException("Usuário ou senha inválidos");
        }

        // 3. Se passou, retorna os dados do usuário
        return new UsuarioResponseDTO(usuario);
    }
}