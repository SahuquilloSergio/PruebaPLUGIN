/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sergio.pluginNB;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import org.kohsuke.github.GHCreateRepositoryBuilder;
import org.kohsuke.github.GitHub;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "File",
        id = "org.sergio.pluginNB.GitHubRepositorio"
)
@ActionRegistration(
        iconBase = "org/sergio/pluginNB/github.png",
        displayName = "#CTL_GitHubRepositorio"
)
@ActionReference(path = "Toolbars/File", position = 0)
@Messages("CTL_GitHubRepositorio=GHRepo")
public final class GitHubRepositorio extends AbstractAction implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO implement action body
    }
    public void crearRepositorio(){
//        FileRepositoryBuilder builder = new FileRepositoryBuilder();
        try {
            String nu = JOptionPane.showInputDialog("Nombre de usuario");
            String password = JOptionPane.showInputDialog("Contraseña");
            GitHub github=GitHub.connectUsingPassword(nu, password);
            GHCreateRepositoryBuilder builder;
            String nombre = JOptionPane.showInputDialog("Nombre del repositorio");
//            String descripcion = JOptionPane.showInputDialog("Descripcion del repositorio");
            
            builder=github.createRepository(nombre);
            builder.create();
        } catch (IOException ex) {
            System.out.println("Error: "+ex);
        }
    }
}
