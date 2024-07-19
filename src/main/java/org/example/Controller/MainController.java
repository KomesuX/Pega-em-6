package org.example.Controller;

import org.example.CadastroReposity;
import org.example.Model.Cadastro;

import org.example.QueryInterface;
import org.json.JSONException;
import org.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/Pega_em_6")
public class MainController {

    @Autowired
    private CadastroReposity cadastroRepositorio;

    @Autowired
    private QueryInterface queryInterface;

    @PostMapping(path="/cadastro/add")
    public @ResponseBody String addNewCadastro (@RequestParam String firstName,
                                                @RequestParam String secondName,
                                                @RequestParam String userName,
                                                @RequestParam String email,
                                                @RequestParam String password) {
        Cadastro cadastro = new Cadastro();
        cadastro.setFirstName(firstName);
        cadastro.setSecondName(secondName);
        cadastro.setUserName(userName);
        cadastro.setEmail(email);
        cadastro.setPassword(password);
        cadastroRepositorio.save(cadastro);

        return "Saved";
    }

    @GetMapping(path="/cadastro/data")
    public @ResponseBody String getUserCadastro(@RequestParam String email,
                                                @RequestParam String password) {
        try {
            Cadastro cadastro = queryInterface.finCadastroByEmail(email).get(0);
            if( cadastro!=null && cadastro.getPassword().equals(password) ){
                JSONObject jsonResponse = new JSONObject();
                try {
                    jsonResponse.put("cadastroId", cadastro.getId());
                    jsonResponse.put("firstName", cadastro.getFirstName());
                    jsonResponse.put("secondName", cadastro.getSecondName());
                    jsonResponse.put("userName", cadastro.getUserName());

                } catch (JSONException e) {
                    e.printStackTrace();
                    return "Fail";
                }

                return jsonResponse.toString();
            }
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        return "Fail";
    }


}
