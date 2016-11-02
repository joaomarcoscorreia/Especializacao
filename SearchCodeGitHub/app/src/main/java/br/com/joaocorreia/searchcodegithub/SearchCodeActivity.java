package br.com.joaocorreia.searchcodegithub;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import br.com.joaocorreia.searchcodegithub.modelo.ItemGitHub;
import br.com.joaocorreia.searchcodegithub.util.Constantes;


public class SearchCodeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_code);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction tx = fragmentManager.beginTransaction();
        if(isTablet()) {
            tx.replace(R.id.id_frame_principal, new ListaCodeFragment());
            tx.replace(R.id.id_frame_secundario, new DetalheFragment());
        }else{
            tx.replace(R.id.id_frame_principal, new ListaCodeFragment());
        }
        tx.commit();

    }

    private boolean isTablet(){
        return getResources().getBoolean(R.bool.tablet);
    }


    public void selecionarOwner(ItemGitHub item) {
        FragmentManager manager = getSupportFragmentManager();

        if(!isTablet()) {

            FragmentTransaction tx = manager.beginTransaction();

            DetalheFragment detalhesFragment = new DetalheFragment();
            Bundle parametros = new Bundle();
            parametros.putSerializable(Constantes.USER, item.getOwner().getLogin());
            detalhesFragment.setArguments(parametros);

            tx.replace(R.id.id_frame_principal, detalhesFragment);
            tx.commit();
        }else{
            DetalheFragment detalhefragment = (DetalheFragment) manager.findFragmentById(R.id.id_frame_secundario);
            detalhefragment.popula(item);
        }
    }
}
