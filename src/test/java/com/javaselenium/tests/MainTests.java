package com.javaselenium.tests;

import com.javaselenium.base.TestBase;
import com.javaselenium.pages.ElementsPage;
import com.javaselenium.pages.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTests extends TestBase {
    MainPage mainPage;
    ElementsPage elementsPage;
    @Test
    public void AcessarPaginaPrincipal() {
        mainPage = new MainPage();
        mainPage.validarPagina();
    }
    @Test
    public void AcessarElementsPage() {
        elementsPage = new ElementsPage();
        elementsPage.AcessarElementsPage();
        elementsPage.ValidarElementPage();
    }

    @Test
    public void PreencherFormValido() {
        String name="Jorge";

        elementsPage = new ElementsPage();
        elementsPage.AcessarElementsPage();
        elementsPage.ValidarElementPage();
        elementsPage.AcessarTextBox();
        elementsPage.PreencherForm(name,"jorge@gmail.com","Rua Pirapora","Rua Piripimpa");

        Assertions.assertEquals("Name:"+name,elementsPage.ValidarOutput());
    }

    @Test
    public void PreencherFormEmailInvalidoSemNome() {
        String name="Jorge";

        elementsPage = new ElementsPage();
        elementsPage.AcessarElementsPage();
        elementsPage.ValidarElementPage();
        elementsPage.AcessarTextBox();
        elementsPage.PreencherForm(name,"EmailErrado","Rua Pirapora","Rua Piripimpa");
        Assertions.assertTrue(elementsPage.ValidarOutputError());
    }

    @Test
    public void SelectCheckBoxNotes (){
        String item ="Notes";
        elementsPage = new ElementsPage();
        elementsPage.AcessarElementsPage();
        elementsPage.AcessarCheckBox();
        elementsPage.ExpandAllCheckBox();
        elementsPage.SelecionarCheckBoxNotes();
        Assertions.assertEquals("You have selected : notes","You have selected : "+elementsPage.SelectedName());
    }
    @Test
    public void SelectCheckBoxCommands (){
        String item ="Commands";
        elementsPage = new ElementsPage();
        elementsPage.AcessarElementsPage();
        elementsPage.AcessarCheckBox();
        elementsPage.ExpandAllCheckBox();
        elementsPage.SelecionarCheckBoxCommands();
        Assertions.assertEquals("You have selected : commands","You have selected : "+elementsPage.SelectedName());
    }
}


