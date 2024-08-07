package br.ufal.ic.p2.jackut;

import easyaccept.script.EchoProcessor;
import java.util.HashMap;
import java.util.Map;

public class Facade {
    public void zerarSistema() {
    }

    public void encerrarSistema(){
    }

    Map<String, User> usersList = new HashMap<>();

    public void criarUsuario(String login, String senha, String nome) throws Exception {
        if(usersList.containsKey(login)) {
            throw new Exception("Conta com esse nome já existe.");
        }

        if (login == null) {
            throw new Exception("Login inválido.");
        } else if (senha == null) {
            throw new Exception("Senha inválida.");
        }

        usersList.put(login, new User(nome, senha));
    }

    public String getAtributoUsuario(String login, String atributo) throws Exception {
        User usuario = usersList.get(login);

        if (usuario == null) {
            throw new Exception("Usuário não cadastrado.");
        } else {
            if (atributo.equals("nome")) {
                return usuario.getName();
            } else if (atributo.equals("senha")) {
                return usuario.getPassword();
            }
        }
        return null;
    }

    public int abrirSessao(String login, String senha) throws Exception {
        User usuario = usersList.get(login);

        if (usuario != null && (login != null && senha != null) && usuario.getPassword().equals(senha)) {
            return 1;
        }

        throw new Exception("Login ou senha inválidos.");
    }
}
