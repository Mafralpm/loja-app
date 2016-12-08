package br.unifor.retail.view.activity;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.rest.spring.annotations.RestService;

import br.unifor.retail.R;
import br.unifor.retail.model.RecordLogin;
import br.unifor.retail.rest.ClientService;
import br.unifor.retail.view.activity.common.BaseActivity;

@EActivity(R.layout.activity_register_user)
public class RegisterUser extends BaseActivity {

    @RestService
    ClientService clientService;
    @ViewById
    protected EditText register_nome;
    @ViewById
    protected EditText register_email;
    @ViewById
    protected EditText register_senha;
    @ViewById
    protected EditText register_confirmar_senha;
    @ViewById
    protected Button register_cadastrar;
    @ViewById
    protected Toolbar toolbarInfo_Client;

    private RecordLogin recordLogin = new RecordLogin();

    private static final String ROLE_CLIENT = "client";

    @AfterViews
    public void begin() {
        toolbarInfo_Client.setTitle("Cadastro");
        toolbarInfo_Client.setBackground(getResources().getDrawable(R.drawable.canto_superior_da_tela));
        setSupportActionBar(toolbarInfo_Client);
    }

    @Background
    @Click
    void register_cadastrar() {
        try {
            recordLogin.getUser().setEmail(register_email.getText().toString().toLowerCase().trim());
            recordLogin.getUser().setPassword(register_senha.getText().toString().trim());
            recordLogin.getUser().setPassword_confirmation(register_confirmar_senha.getText().toString().trim());
            recordLogin.getUser().setRole(ROLE_CLIENT);
            recordLogin.getCliente().setNome_cliente(register_nome.getText().toString().trim());
            clientService.cadastraCliente(recordLogin);

            goMainActivity();
        } catch (Exception e) {
            Log.d("LOgin", e.toString());
        }

    }

    private void goMainActivity(){
        Intent intent = new Intent(this, MainActivity_.class);
        startActivity(intent);
    }
}