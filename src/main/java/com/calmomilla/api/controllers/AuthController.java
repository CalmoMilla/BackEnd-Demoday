package com.calmomilla.api.controllers;

import com.calmomilla.api.dto.input.AuthDTO;
import com.calmomilla.api.dto.input.CadastrarDTO;
import com.calmomilla.api.dto.input.loginGoogle.LoginGoogleInput;
import com.calmomilla.api.dto.input.paciente.CadastroPacienteInput;
import com.calmomilla.api.dto.input.psicologo.CadastroPsicologoInput;
import com.calmomilla.api.dto.input.recuperarSenha.RecuperarSenhaInput;
import com.calmomilla.api.dto.input.recuperarSenhaRedefinir.RecuperarSenhaRedefinirInput;
import com.calmomilla.api.dto.output.paciente.CadastroPacienteOutput;
import com.calmomilla.api.dto.output.psicologo.CadastroPsicologoOutput;
import com.calmomilla.api.dto.output.LoginOutput;
import com.calmomilla.api.dto.output.UsuarioOutput;
import com.calmomilla.api.dto.output.recuperarSenha.RecuperarSenhaOutput;
import com.calmomilla.domain.service.AuthService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;

@AllArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login/google")
    public ResponseEntity<?> loginGoogle(@RequestBody @Valid LoginGoogleInput loginGoogleInput) throws NoSuchMethodException, ParseException {
        return authService.loginGoogle(loginGoogleInput);
    }
    @PostMapping("/login")
    public ResponseEntity<LoginOutput> login(@RequestBody @Valid AuthDTO authDTO){

     return authService.login(authDTO);

    }

    @PostMapping("/cadastro-paciente")
    public ResponseEntity<CadastroPacienteOutput> cadastrar(@RequestBody @Valid CadastroPacienteInput pacienteInput) throws NoSuchMethodException, ParseException {

        return authService.cadastrar(pacienteInput);

    }

    @PostMapping("/cadastro-psicologo")
    public ResponseEntity<CadastroPsicologoOutput> cadastrar(@RequestBody @Valid CadastroPsicologoInput cadastroPsicologoInput) throws NoSuchMethodException, ParseException {

        return authService.cadastrar(cadastroPsicologoInput);

    }

    @PostMapping("/esqueciASenha")
    public ResponseEntity<RecuperarSenhaOutput>recuperarSenha(@RequestBody @Valid RecuperarSenhaInput recuperarSenhaInput) throws NoSuchMethodException {
        return  authService.recuperarSenha(recuperarSenhaInput);
    }
    @PostMapping("/esqueciASenha/redefinir")
    public ResponseEntity<RecuperarSenhaOutput>recuperarSenhaRedefinir(@RequestBody @Valid RecuperarSenhaRedefinirInput recuperarSenhaInput) throws NoSuchMethodException {
        return  authService.recuperarSenhaRedefinir(recuperarSenhaInput);
    }


}

