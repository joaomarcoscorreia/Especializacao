package br.com.joaocorreia.searchcodegithub;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CursorAdapter;
import android.widget.ListView;

import br.com.joaocorreia.searchcodegithub.repositorio.OwnerRepositorio;
import br.com.joaocorreia.searchcodegithub.util.OwnerCursosAdapter;

public class FavoriteActivity extends AppCompatActivity {

    OwnerRepositorio ownerRepositorio;
    CursorAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        ownerRepositorio = new OwnerRepositorio(this);
        

        mAdapter = new OwnerCursosAdapter(this,null);
        ListView listView = (ListView) findViewById(R.id.listView_favorito);
        listView.setAdapter(mAdapter);



    }
}
