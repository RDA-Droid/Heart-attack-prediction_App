package com.ado_tech.myapplication.formulario;

public interface BaseView<T extends BasePresenter> {

    void setPresenter(T presenter);
    void onNoConnection();
}