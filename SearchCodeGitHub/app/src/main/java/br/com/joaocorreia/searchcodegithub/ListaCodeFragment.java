package br.com.joaocorreia.searchcodegithub;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.com.joaocorreia.searchcodegithub.api.GitHubHttp;
import br.com.joaocorreia.searchcodegithub.modelo.ItemGitHub;
import br.com.joaocorreia.searchcodegithub.util.ItemGitHubAdapter;
import br.com.joaocorreia.searchcodegithub.util.UtilQuery;

/**
 * Created by joaocorreia on 31/10/16.
 */
public class ListaCodeFragment extends Fragment implements SearchView.OnQueryTextListener {

    ItemGitHubAdapter adapter = null;
    List<ItemGitHub> list = null;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list_code,container,false);
        ListView listview = (ListView) view.findViewById(R.id.listView);
        setHasOptionsMenu(true);
        list = new ArrayList<ItemGitHub>();
        adapter = new ItemGitHubAdapter(list,getContext());

        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ItemGitHub item = (ItemGitHub) adapterView.getItemAtPosition(i);

//                Intent it = new Intent(getContext(), DetalheActivity.class);
//                it.putExtra(Constantes.USER, item.getOwner().getLogin());
//                startActivity(it);
//                FragmentManager fragmentManager = getFragmentManager();
//                FragmentTransaction tx = fragmentManager.beginTransaction();
//                tx.replace(R.id.id_frame_detalhe, new DetalheFragment());
//                tx.commit();
                SearchCodeActivity searchCodeActivity = (SearchCodeActivity) getActivity();
                searchCodeActivity.selecionarOwner(item);
            }
        });

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu,menuInflater);
        menuInflater.inflate(R.menu.menu_lista_git,menu);

        //getMenuInflater().inflate(R.menu.menu_lista_git,menu);
        MenuItem searchItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(this);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case(R.id.menu_favorito):
                Intent it = new Intent(getContext(),FavoriteActivity.class);
                startActivity(it);
                break;

        }

        return super.onOptionsItemSelected(item);
    }
    // ---- OnQueryTextListener
    @Override
    public boolean onQueryTextSubmit(String query) {
        new itemTask().execute(query);

        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return true;
    }


    class itemTask extends AsyncTask<String, Void, List<ItemGitHub>> {


        @Override
        protected List<ItemGitHub> doInBackground(String... pStrings) {
            if(pStrings[0].contains(",")){
                String[] st = pStrings[0].split(",");
                return GitHubHttp.searchGit(UtilQuery.makeQuery(st[0], st[1]));
            } else{
                return GitHubHttp.searchGit(UtilQuery.makeQueryNoLanguage(pStrings[0]));
            }
        }

        @Override
        protected void onPostExecute(List<ItemGitHub> weather) {
            super.onPostExecute(weather);
            list.addAll(weather);
            adapter.notifyDataSetChanged();
        }
    }


}
