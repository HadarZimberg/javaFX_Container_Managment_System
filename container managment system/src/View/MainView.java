package View;

import java.util.Stack;
import Model.Container;
import Model.Port;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;

public class MainView {
	private Stage _stage;
	private Group _root;
	private Scene _scene;
	private Button _move, _restart;
	private Port _port;

	public MainView(Stage stage) {
		_stage = stage;
		_root = new Group();
		_scene = new Scene(_root, 900, 600,Color.LIGHTBLUE);
		_stage.setScene(_scene);
		_stage.show();

		_port = new Port();

		_move = new Button("move");
		_move.setLayoutX(20);
		_move.setLayoutY(20);
		_move.setPrefHeight(40);

		_restart = new Button("restart");
		_restart.setLayoutX(20);
		_restart.setLayoutY(70);
		_restart.setPrefHeight(40);
	}

	public Button getMove() {
		return _move;
	}

	public Button getRestart() {
		return _restart;
	}

	public void addEventHandler(EventHandler<MouseEvent> event) {
		_scene.addEventHandler(MouseEvent.MOUSE_CLICKED, event);
	}

	public void addMoveButton() {
		_root.getChildren().add(_move);
	}

	public void addRestartButton() {
		_root.getChildren().add(_restart);
	}

	public void clear() {
		_root.getChildren().clear();
	}

	public Group getRoot() {
		return _root;
	}

	public void show(Port port) {
		Polygon ship = new Polygon();
		ship.getPoints().addAll(new Double[] {
				25.0, 520.0,
				780.0, 520.0,
				880.0, 360.0,
				10.0, 360.0
		});
		ship.setFill(Color.DARKRED);
		ship.setStroke(Color.BLACK);
		ship.setStrokeWidth(1);
		_root.getChildren().add(ship);
		
		Rectangle wharf = new Rectangle();
		//sizes according to the window size:
		wharf.setX(0);
		wharf.setY(520);
		wharf.setWidth(900);
		wharf.setHeight(80);
		wharf.setFill(Color.GREY);
		wharf.setStroke(Color.BLACK);
		wharf.setStrokeWidth(1);
		
		Polygon truck = new Polygon();
		truck.getPoints().addAll(new Double[] {
				300.0, 450.0,
				250.0, 450.0,
				250.0, 510.0,
				300.0, 510.0,
				300.0, 500.0,
				500.0, 500.0,
				500.0, 490.0,
				300.0, 490.0
		});
		truck.setFill(Color.LIGHTGOLDENRODYELLOW);
		truck.setStroke(Color.ROSYBROWN);
		truck.setStrokeWidth(3);
		truck.setStrokeType(StrokeType.INSIDE);

		Circle wheel1 = new Circle();
		wheel1.setCenterX(280);
		wheel1.setCenterY(510);
		wheel1.setRadius(10);
		Circle wheel2 = new Circle();
		wheel2.setCenterX(440);
		wheel2.setCenterY(510);
		wheel2.setRadius(10);
		Circle wheel3 = new Circle();
		wheel3.setCenterX(470);
		wheel3.setCenterY(510);
		wheel3.setRadius(10);
		
		_root.getChildren().addAll(wharf, truck, wheel1, wheel2, wheel3);

		Stack<Container> tempStack = new Stack<Container>();
		for (int i = 0; i < port.getCurrNumOfContainers(); i++) { //Show the containers
			Container curr = port.getStackOfContainers().pop();
			ContainerView c1 = new ContainerView(curr);
			c1.show(_root);
			tempStack.push(curr);
		}
		for (int i = 0; i < port.getCurrNumOfContainers(); i++) {
			port.getStackOfContainers().push(tempStack.pop());
		}

		for (int i = 0; i < port.getCurrNumOfUnload(); i++) { //Show the containers
			Container curr = port.getUnloadingStack().pop();
			ContainerView c2 = new ContainerView(curr);
			c2.show(_root);
			tempStack.push(curr);
		}
		for (int i = 0; i < port.getCurrNumOfUnload(); i++) {
			port.getUnloadingStack().push(tempStack.pop());
		}

		for (int i = 0; i < port.getCurrNumOfUpload(); i++) { //Show the containers
			Container curr = port.getUploadingStack().pop();
			ContainerView c3 = new ContainerView(curr);
			c3.show(_root);
			tempStack.push(curr);
		}
		for (int i = 0; i < port.getCurrNumOfUpload(); i++) {
			port.getUploadingStack().push(tempStack.pop());
		}	
	}

}
