package br.com.joaocorreia.searchcodegithub.api;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.joaocorreia.searchcodegithub.modelo.ItemGitHub;
import br.com.joaocorreia.searchcodegithub.modelo.Owner;
import br.com.joaocorreia.searchcodegithub.util.Constantes;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by joaocorreia on 23/10/16.
 */
public class GitHubHttp {

    public static List<ItemGitHub> searchGit(String query){
        List<ItemGitHub> itens = new ArrayList<>();

        OkHttpClient client = new OkHttpClient();
        String url1 = String.format(Constantes.URL_PADRAO, query);

        Request request = new Request.Builder()
                .url(url1)
                .build();

        Response response = null;
        try {
            response = client.newCall(request).execute();

            String json = response.body().string();
            // from here!
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray("items");
            String jsonList = jsonArray.toString();

            Gson gson = new Gson();
            ItemGitHub[] vetores = gson.fromJson(jsonList, ItemGitHub[].class);
            itens.addAll(Arrays.asList(vetores));

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return itens;
    }

    public static Owner searchUser(String query){

        Owner user = null;

        OkHttpClient client = new OkHttpClient();
        String url1 = String.format(Constantes.URL_USER, query);

        Request request = new Request.Builder()
                .url(url1)
                .build();

        Response response = null;
        try {
            response = client.newCall(request).execute();

            String json = response.body().string();
            // from here!
            JSONObject jsonObject = new JSONObject(json);

            Gson gson = new Gson();
            user = gson.fromJson(jsonObject.toString(), Owner.class);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return user;
    }

}
