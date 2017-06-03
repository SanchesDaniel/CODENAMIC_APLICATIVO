package com.example.danieldigregorio.pap_ads5;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by danieldigregorio on 24/05/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String BANCO_DADOS = "TaNaMao";
    private static int VERSAO = 1;

    public DatabaseHelper(Context context) {
        super(context, BANCO_DADOS, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table usuario(" +
                "  id_usuario int," +
                "  nome varchar2(30)," +
                "  email varchar2(50)," +
                "  cfp varchar2 (11)," +
                "  data_nascimento date," +
                "  telefone varchar2(18)," +
                "  rua varchar2(20)," +
                "  bairro varchar2(20)," +
                "  cidade varchar2(20)," +
                "  estado varchar2(20)," +
                "  constraint pk_usuario primary key (id_usuario));");
        db.execSQL("create table servico(" +
                "  id_servico int," +
                "  titulo_servico varchar2(25)," +
                "  dsc_servico varchar2(100)," +
                " " +
                "  constraint pk_servico primary key (id_servico)" +
                ");");
        db.execSQL("create table orcamento(" +
                "  id_orcamento int," +
                "  id_usuario_cliente int," +
                "  id_usuario_vendedor int," +
                "  id_servico int," +
                "  valor binary_double," +
                "  quantidade_horas_trab int," +
                "  constraint pk_orcamento primary key (id_orcamento)," +
                "  constraint fk_usuario_cliente foreign key (id_usuario_cliente) references usuario(id_usuario)," +
                "  constraint fk_usuario_vendedor foreign key (id_usuario_vendedor) references usuario(id_usuario)," +
                "  constraint fk_servico foreign key (id_servico) references servico(id_servico)" +
                ");");

        db.execSQL("create table servico_solicitado(\n" +
                "  id_serv_solicitado int,\n" +
                "  id_servico int,\n" +
                "  id_orcamento int,\n" +
                "  id_usuario_cliente int,\n" +
                "  id_usuario_vendedor int,\n" +
                "  valor_final binary_double,\n" +
                "  feedback_usuario_cliente int,\n" +
                " \n" +
                "  constraint pk_serv_solicitado primary key (id_serv_solicitado)," +
                "  constraint fk_servico_2 foreign key (id_servico) references servico(id_servico)," +
                "  constraint fk_orcamento_2 foreign key (id_orcamento) references orcamento(id_orcamento)," +
                "  constraint fk_usuario_cliente_2 foreign key (id_usuario_cliente) references usuario(id_usuario)," +
                "  constraint fk_usuario_vendedor_2 foreign key (id_usuario_vendedor) references usuario(id_usuario)" +
                ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,
                          int newVersion) {
        db.execSQL("ALTER TABLE gasto ADD COLUMN pessoa TEXT");
    }
}

