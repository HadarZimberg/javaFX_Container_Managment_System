package application;

import Model.Model;
import View.MainView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class Controller {
	private MainView _view;
	private Model _model;

	public Controller(MainView mainView, Model model) {
		_view = mainView;
		_model = model;
		_view.show(_model.getPort());
		
		EventHandler<MouseEvent> click = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				int x = (int)event.getX();
				int y = (int)event.getY();
				_model.getPort().setAllFramesToBlack(x, y);
				if (event.getButton() == MouseButton.PRIMARY) {
					_model.getPort().mark(x, y);
					_view.show(_model.getPort());
				}
			} 
		}; //event handler
		
		_view.addEventHandler(click);
		_view.addMoveButton();
		_view.addRestartButton();

		_view.getMove().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				_model.getPort().move();
				_view.clear();
				_view.addMoveButton();
				_view.addRestartButton();
				_view.show(_model.getPort());
			}
		});

		_view.getRestart().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				_model.getPort().restart();
				_view.clear();
				_view.addMoveButton();
				_view.addRestartButton();
				_view.show(_model.getPort());
			}
		});
	}
}
