package br.com.joaocorreia.searchcodegithub;


import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import br.com.joaocorreia.searchcodegithub.api.GitHubHttp;
import br.com.joaocorreia.searchcodegithub.modelo.ItemGitHub;
import br.com.joaocorreia.searchcodegithub.modelo.Owner;
import br.com.joaocorreia.searchcodegithub.repositorio.OwnerRepositorio;
import br.com.joaocorreia.searchcodegithub.util.Constantes;


public class DetalheFragment extends Fragment {

    private OwnerRepositorio ownerRepositorio = null;
    private Owner _owner = null;
    private View view = null;
    private  String query_user = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_detalhe, container, false);

        Bundle parametros = getArguments();
        if(parametros!=null){
            query_user = (String)parametros.getSerializable(Constantes.USER);
        }

        if(query_user!=null && !query_user.isEmpty()) {
            detailTaks detail = new detailTaks(query_user);
            detail.execute();
        }
        return view;
    }

    public void popula(ItemGitHub item){
        detailTaks detail = new detailTaks(item.getOwner().getLogin());
        detail.execute();
    }
    private void updateUI(Owner pUser){
        if (pUser != null) {


            TextView tx_email = (TextView) view.findViewById(R.id.id_email);
            TextView tx_user = (TextView) view.findViewById(R.id.id_user_name);
            final TextView tx_blog = (TextView) view.findViewById(R.id.id_blog);
            TextView tx_dt_criacao = (TextView) view.findViewById(R.id.id_dt_cricao);
            ImageButton button = (ImageButton) view.findViewById(R.id.id_favorito);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    ownerRepositorio = new OwnerRepositorio(getContext());


                    ownerRepositorio.salvar(_owner);
                    Toast.makeText(getContext(), _owner.get_id() + " ", Toast.LENGTH_SHORT).show();
                }
            });

            tx_blog.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    TextView tx = (TextView) view.findViewById(R.id.id_blog);
                    String st = tx.getText().toString();
                    Uri uri = Uri.parse(st);
                    Intent it = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(it);

                }
            });
            tx_user.setText(pUser.getLogin());
            tx_email.setText(pUser.getEmail());

            if (pUser.getBlog() != null && !pUser.getBlog().equals("")) {
                tx_blog.setText(pUser.getBlog());
            } else {
                tx_blog.setText(pUser.getHtml_url());
            }
            tx_blog.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
            String dt = pUser.getCreated_at().substring(0, 10);
            tx_dt_criacao.setText(dt);
        }
    }



    class detailTaks extends AsyncTask<Void, Void, Owner> {
        String query ="";

        detailTaks(String pQuery){
            this.query = pQuery;
        }

        @Override
        protected Owner doInBackground(Void... voids) {
            return GitHubHttp.searchUser(query);
        }

        @Override
        protected void onPostExecute(Owner owner) {
            super.onPostExecute(owner);
            if(owner!=null){
                updateUI(owner);
                _owner = owner;
                ImageView imUser = (ImageView) view.findViewById(R.id.id_image);
                Glide.with(imUser.getContext()).load(owner.getAvatarUrl()).into(imUser);
            }


        }
    }

}
