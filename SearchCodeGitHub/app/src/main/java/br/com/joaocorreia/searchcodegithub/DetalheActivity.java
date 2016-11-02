package br.com.joaocorreia.searchcodegithub;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import br.com.joaocorreia.searchcodegithub.modelo.Owner;
import br.com.joaocorreia.searchcodegithub.repositorio.OwnerRepositorio;


public class DetalheActivity extends AppCompatActivity {

    private OwnerRepositorio ownerRepositorio = null;
    private Owner _owner = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction tx = fragmentManager.beginTransaction();

            tx.replace(R.id.id_frame_secundario, new DetalheFragment());


        tx.commit();
    }

}
