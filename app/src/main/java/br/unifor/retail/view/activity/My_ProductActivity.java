package br.unifor.retail.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeader;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import org.json.JSONObject;

import java.util.ArrayList;

import br.unifor.retail.R;
import br.unifor.retail.adapter.Adapter_ListView_My_Product;
import br.unifor.retail.singleton.Singleton_My_Product;

import static com.facebook.AccessToken.getCurrentAccessToken;


public class My_ProductActivity extends AppCompatActivity {

    private Drawer.Result navigationDrawerLeft;
    private AccountHeader.Result headerNavigationLeft;
    private Toolbar toolbar;
    private String userId;
    private String name;
    private String grafiUrl;
    private String profileImgUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_prodcuct);
        toolbar = (Toolbar) findViewById(R.id.toolbarMyProduct);
        toolbar.setTitle("Meus Produtos");
        toolbar.setBackground(getResources().getDrawable(R.drawable.canto_superior_da_tela));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ArrayList<Singleton_My_Product> singleton_my_products = todos_Os_Produtos();

        Adapter_ListView_My_Product adapter = new Adapter_ListView_My_Product(singleton_my_products, getApplicationContext());

        ListView listView;
        listView = (ListView) findViewById(R.id.myproduct);

        listView.setAdapter(adapter);


        Profile profile = Profile.getCurrentProfile();
        if (getCurrentAccessToken() != null) {
            Log.d("Teste", AccessToken.getCurrentAccessToken().getUserId().toString());


            userId = AccessToken.getCurrentAccessToken().getUserId().toString();
            profileImgUrl = "https://graph.facebook.com/" + userId + "/picture?type=large";
            grafiUrl = "https://graph.facebook.com/me?access_token=" + AccessToken.getCurrentAccessToken().getToken();
            name = profile.getName();
            //   email =
            GraphRequest request = GraphRequest.newMeRequest(AccessToken.getCurrentAccessToken(),
                    new GraphRequest.GraphJSONObjectCallback() {
                        @Override
                        public void onCompleted(JSONObject object, GraphResponse response) {

                            Log.d("dqwdqqd", object.toString());
                            Log.d("dqwdqqd", grafiUrl);


                        }

                    });

            request.executeAsync();

            Log.d("xs", userId);
        }

        createNavigationDrawer();


    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_geral, menu);
        return true;
    }

    public ArrayList<Singleton_My_Product> todos_Os_Produtos() {
        ArrayList<Singleton_My_Product> singleton_my_products = new ArrayList<>();


        singleton_my_products.add(new Singleton_My_Product(R.drawable.pandalambendo, "1", "Blusa preta", "10/04/2016"));
        singleton_my_products.add(new Singleton_My_Product(R.drawable.felipemassapilotof1, "2", "Blusa branca", "10/04/2016"));
        singleton_my_products.add(new Singleton_My_Product(R.drawable.pandalambendo, "4", "Blusa preta", "10/04/2016"));
        singleton_my_products.add(new Singleton_My_Product(R.drawable.felipemassapilotof1, "5", "Blusa branca", "10/04/2016"));
        singleton_my_products.add(new Singleton_My_Product(R.drawable.pandalambendo, "7", "Blusa preta", "10/04/2016"));
        singleton_my_products.add(new Singleton_My_Product(R.drawable.felipemassapilotof1, "8", "Blusa branca", "10/04/2016"));
        singleton_my_products.add(new Singleton_My_Product(R.drawable.pandalambendo, "10", "Blusa preta", "10/04/2016"));
        singleton_my_products.add(new Singleton_My_Product(R.drawable.felipemassapilotof1, "11", "Blusa branca", "10/04/2016"));
        singleton_my_products.add(new Singleton_My_Product(R.drawable.pandalambendo, "1", "Blusa preta", "10/04/2016"));
        singleton_my_products.add(new Singleton_My_Product(R.drawable.felipemassapilotof1, "2", "Blusa branca", "10/04/2016"));
        singleton_my_products.add(new Singleton_My_Product(R.drawable.pandalambendo, "4", "Blusa preta", "10/04/2016"));
        singleton_my_products.add(new Singleton_My_Product(R.drawable.felipemassapilotof1, "5", "Blusa branca", "10/04/2016"));
        singleton_my_products.add(new Singleton_My_Product(R.drawable.pandalambendo, "7", "Blusa preta", "10/04/2016"));
        singleton_my_products.add(new Singleton_My_Product(R.drawable.felipemassapilotof1, "8", "Blusa branca", "10/04/2016"));
        singleton_my_products.add(new Singleton_My_Product(R.drawable.pandalambendo, "10", "Blusa preta", "10/04/2016"));
        singleton_my_products.add(new Singleton_My_Product(R.drawable.felipemassapilotof1, "11", "Blusa branca", "10/04/2016"));
        singleton_my_products.add(new Singleton_My_Product(R.drawable.pandalambendo, "1", "Blusa preta", "10/04/2016"));
        singleton_my_products.add(new Singleton_My_Product(R.drawable.felipemassapilotof1, "2", "Blusa branca", "10/04/2016"));
        singleton_my_products.add(new Singleton_My_Product(R.drawable.pandalambendo, "4", "Blusa preta", "10/04/2016"));
        singleton_my_products.add(new Singleton_My_Product(R.drawable.felipemassapilotof1, "5", "Blusa branca", "10/04/2016"));
        singleton_my_products.add(new Singleton_My_Product(R.drawable.pandalambendo, "7", "Blusa preta", "10/04/2016"));
        singleton_my_products.add(new Singleton_My_Product(R.drawable.felipemassapilotof1, "8", "Blusa branca", "10/04/2016"));
        singleton_my_products.add(new Singleton_My_Product(R.drawable.pandalambendo, "10", "Blusa preta", "10/04/2016"));
        singleton_my_products.add(new Singleton_My_Product(R.drawable.felipemassapilotof1, "11", "Blusa branca", "10/04/2016"));
        singleton_my_products.add(new Singleton_My_Product(R.drawable.pandalambendo, "1", "Blusa preta", "10/04/2016"));
        singleton_my_products.add(new Singleton_My_Product(R.drawable.felipemassapilotof1, "2", "Blusa branca", "10/04/2016"));
        singleton_my_products.add(new Singleton_My_Product(R.drawable.pandalambendo, "4", "Blusa preta", "10/04/2016"));
        singleton_my_products.add(new Singleton_My_Product(R.drawable.felipemassapilotof1, "5", "Blusa branca", "10/04/2016"));
        singleton_my_products.add(new Singleton_My_Product(R.drawable.pandalambendo, "7", "Blusa preta", "10/04/2016"));
        singleton_my_products.add(new Singleton_My_Product(R.drawable.felipemassapilotof1, "8", "Blusa branca", "10/04/2016"));
        singleton_my_products.add(new Singleton_My_Product(R.drawable.pandalambendo, "10", "Blusa preta", "10/04/2016"));
        singleton_my_products.add(new Singleton_My_Product(R.drawable.felipemassapilotof1, "11", "Blusa branca", "10/04/2016"));
        singleton_my_products.add(new Singleton_My_Product(R.drawable.pandalambendo, "1", "Blusa preta", "10/04/2016"));
        singleton_my_products.add(new Singleton_My_Product(R.drawable.felipemassapilotof1, "2", "Blusa branca", "10/04/2016"));
        singleton_my_products.add(new Singleton_My_Product(R.drawable.pandalambendo, "4", "Blusa preta", "10/04/2016"));
        singleton_my_products.add(new Singleton_My_Product(R.drawable.felipemassapilotof1, "5", "Blusa branca", "10/04/2016"));
        singleton_my_products.add(new Singleton_My_Product(R.drawable.pandalambendo, "7", "Blusa preta", "10/04/2016"));
        singleton_my_products.add(new Singleton_My_Product(R.drawable.felipemassapilotof1, "8", "Blusa branca", "10/04/2016"));
        singleton_my_products.add(new Singleton_My_Product(R.drawable.pandalambendo, "10", "Blusa preta", "10/04/2016"));
        singleton_my_products.add(new Singleton_My_Product(R.drawable.felipemassapilotof1, "11", "Blusa branca", "10/04/2016"));
        singleton_my_products.add(new Singleton_My_Product(R.drawable.pandalambendo, "1", "Blusa preta", "10/04/2016"));
        singleton_my_products.add(new Singleton_My_Product(R.drawable.felipemassapilotof1, "2", "Blusa branca", "10/04/2016"));
        singleton_my_products.add(new Singleton_My_Product(R.drawable.pandalambendo, "4", "Blusa preta", "10/04/2016"));
        singleton_my_products.add(new Singleton_My_Product(R.drawable.felipemassapilotof1, "5", "Blusa branca", "10/04/2016"));
        singleton_my_products.add(new Singleton_My_Product(R.drawable.pandalambendo, "7", "Blusa preta", "10/04/2016"));
        singleton_my_products.add(new Singleton_My_Product(R.drawable.felipemassapilotof1, "8", "Blusa branca", "10/04/2016"));
        singleton_my_products.add(new Singleton_My_Product(R.drawable.pandalambendo, "10", "Blusa preta", "10/04/2016"));
        singleton_my_products.add(new Singleton_My_Product(R.drawable.felipemassapilotof1, "11", "Blusa branca", "10/04/2016"));


        return singleton_my_products;
    }

    private void goLoginScreen() {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }


    private void createNavigationDrawer() {
        //NAVIGATION DRAWER
        headerNavigationLeft = new AccountHeader()
                .withActivity(this)
                .withCompactStyle(false)
//                .withSavedInstance(savedInstanceState)
                .withThreeSmallProfileImages(true)
                .withHeaderBackground(R.drawable.menu)
                .addProfiles(
                        new ProfileDrawerItem().withName(name).withEmail("vania.almeida28@hotmail.com").withIcon(profileImgUrl))
                .build();


        navigationDrawerLeft = new Drawer()
                .withActivity(this)
                .withToolbar(toolbar)
                .withDisplayBelowToolbar(false)
                .withActionBarDrawerToggleAnimated(true)
                .withDrawerGravity(Gravity.LEFT)
//                .withSavedInstance(savedInstanceState)
                .withSelectedItem(-1)
                .withActionBarDrawerToggle(true)
                .withAccountHeader(headerNavigationLeft)
                   /*.withOnDrawerNavigationListener(new Drawer.OnDrawerNavigationListener() {
                       @Override
                       public boolean onNavigationClickListener(View view) {
                           return false;
                       }
                   })*/
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l, IDrawerItem iDrawerItem) {
                        switch (i) {
                            case 0:
                                Intent intent = new Intent(My_ProductActivity.this, InfoClientActivity.class);
                                startActivity(intent);
                                break;
                            case 1:
                                Intent intent1 = new Intent(My_ProductActivity.this, CartActivity.class);
                                startActivity(intent1);
                                break;
                            case 2:
                                Intent intent2 = new Intent(My_ProductActivity.this, My_ProductActivity.class);
                                startActivity(intent2);
                                break;
                            case 3:
                                Intent intent3 = new Intent(My_ProductActivity.this, HistoryActivity.class);
                                startActivity(intent3);
                                break;
                            case 4:
                                LoginManager.getInstance().logOut();
                                goLoginScreen();
                                break;


                        }
//                        Toast.makeText(My_ProductActivity.this, "Item: " + i, Toast.LENGTH_SHORT).show();
                    }
                })
                .withOnDrawerItemLongClickListener(new Drawer.OnDrawerItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l, IDrawerItem iDrawerItem) {
                        Toast.makeText(My_ProductActivity.this, "onItemLongClick: " + i, Toast.LENGTH_SHORT).show();
                        return false;
                    }
                })
                .build();


        navigationDrawerLeft.addItem(new PrimaryDrawerItem().withName("Perfil").withIcon(getResources().getDrawable(R.drawable.perfil)));
        navigationDrawerLeft.addItem(new PrimaryDrawerItem().withName("Carrinho").withIcon(getResources().getDrawable(R.drawable.carrinho)));
        navigationDrawerLeft.addItem(new PrimaryDrawerItem().withName("Meus pedidos").withIcon(getResources().getDrawable(R.drawable.pedidos)));
        navigationDrawerLeft.addItem(new PrimaryDrawerItem().withName("Historico de itens").withIcon(getResources().getDrawable(R.drawable.visualizacao)));
        navigationDrawerLeft.addItem(new PrimaryDrawerItem().withName("Sair").withIcon(getResources().getDrawable(R.drawable.sair)));
    }


}
