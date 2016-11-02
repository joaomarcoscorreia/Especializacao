package br.com.joaocorreia.searchcodegithub.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import br.com.joaocorreia.searchcodegithub.R;
import br.com.joaocorreia.searchcodegithub.modelo.ItemGitHub;

/**
 * Created by joaocorreia on 25/10/16.
 */
public class ItemGitHubAdapter extends BaseAdapter {

    private List<ItemGitHub> itens;
    private Context ctx;

    public ItemGitHubAdapter(List<ItemGitHub> itens, Context ctx) {
        this.itens = itens;
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return itens.size();
    }

    @Override
    public Object getItem(int i) {
        return itens.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //1 passo
        ItemGitHub item = itens.get(i);


        ViewHolder holder = null;
        //2 passo
        if(view == null){
            view = LayoutInflater.from(ctx).inflate(R.layout.list_adapter_principal, null);
        holder = new ViewHolder();

            holder.imUser =  (ImageView) view.findViewById(R.id.imageView);
            holder.tx_login = (TextView) view.findViewById(R.id.id_login);
            holder.tx_description = (TextView) view.findViewById(R.id.id_description);
            holder.tx_url_repos = (TextView) view.findViewById(R.id.id_url_repos);

            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }

        //ImageView imUser = (ImageView) retorno.findViewById(R.id.imageView);
        Glide.with(holder.imUser.getContext()).load(item.getOwner().getAvatarUrl()).into(holder.imUser);

        //TextView tx_login = (TextView) retorno.findViewById(R.id.id_login);
        //TextView tx_description = (TextView) retorno.findViewById(R.id.id_description);
        //TextView tx_url_repos = (TextView) retorno.findViewById(R.id.id_url_repos);

        holder.tx_login.setText(String.valueOf(item.getOwner().getLogin()));
        holder.tx_description.setText(String.valueOf(item.getDescription()));
        holder.tx_url_repos.setText(String.valueOf(item.getOwner().getHtmlUrl()));

        return view;
    }

    static class ViewHolder{
        ImageView imUser;
        TextView tx_login ;
        TextView tx_description ;
        TextView tx_url_repos ;

    }
}
