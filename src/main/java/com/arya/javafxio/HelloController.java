package com.arya.javafxio;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HelloController {

    public ListView<Comment> comments;
    public TextField username;
    public TextField comment;

    private ObservableList<Comment> listComment;
    private final String defaultFile = "data/comment.json";
    private Gson gson;

    public void initialize() {
        listComment = FXCollections.observableArrayList();
        comments.setItems(listComment);
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public void add(ActionEvent actionEvent) {
        listComment.add(
                new Comment(
                        username.getText(),
                        comment.getText()
                )
        );
        username.setText("");
        comment.setText("");
    }

    public void save1(ActionEvent actionEvent) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(defaultFile));
        writer.write(gson.toJson(listComment));
        writer.close();
    }

    public void load1(ActionEvent actionEvent) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(defaultFile));
        listComment.clear();
        listComment.addAll(gson.fromJson(reader, Comment[].class));
        reader.close();
    }

    public void save2(ActionEvent actionEvent) throws IOException {
        Path path = Paths.get(defaultFile);
        Files.write(path, gson.toJson(listComment).getBytes());
    }

    public void load2(ActionEvent actionEvent) throws IOException {
        Path path = Paths.get(defaultFile);
        listComment.clear();
        listComment.addAll(gson.fromJson(Files.readString(path), Comment[].class));
    }
}