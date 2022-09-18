package com.chano.personerosapp.Service;

import com.chano.personerosapp.Model.Login;
import com.chano.personerosapp.Model.Response;
import com.chano.personerosapp.Model.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface IUsuario {
    @GET("/api/Usuario/{id}")
    Call<Response<Usuario>> getUserById(
        @Path("id") int idUsuario
    );

    @POST("/api/Usuario/login/movil")
    Call<Response<Usuario>> loginUser(
        @Body Login login
    );
}
