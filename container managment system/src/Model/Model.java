package Model;

import java.util.Stack;

public class Model {
	private Port _port;

	public Model() {
		_port = new Port();
	}

	public Port getPort() {
		return _port;
	}

	public Stack<Container> getStackOfContainers() {
		return _port.getStackOfContainers();
	}

	public Stack<Container> getUnloadingStack() {
		return _port.getUnloadingStack();
	}

	public Stack<Container> getUploadingStack() {
		return _port.getUploadingStack();
	}

	public void addAllContainers() {
		_port.addAllContainers();
	}

	public void setLocation(Container curr) {
		_port.setLocation(curr);
	}

	public int getCurrNumOfContainers() {
		return _port.getCurrNumOfContainers();
	}


	public int getCurrNumOfUnload() {
		return _port.getCurrNumOfUnload();
	}


	public int getCurrNumOfUpload() {
		return _port.getCurrNumOfUpload();
	}


	public int getUnloadX() {
		return _port.getUnloadX();
	}


	public int getUnloadY() {
		return _port.getUnloadX();
	}


	public int getTruckTop() {
		return _port.getTruckTop();
	}


	public boolean getIsMark() {
		return _port.getIsMark();
	}


	public boolean getIsUpload() {
		return _port.getIsUpload();
	}

	public void setCurrNumOfContainers(int num) {
		_port.setCurrNumOfContainers(num);
	}

	public void setCurrNumOfUnloads(int num) {
		_port.setCurrNumOfUnloads(num);
	}

	public void setCurrNumOfUploads(int num) {
		_port.setCurrNumOfUploads(num);
	}

	public void setIsMark(boolean bool) {
		_port.setIsMark(bool);
	}

	public void setIsUpload(boolean bool) {
		_port.setIsUpload(bool);
	}

	public void setUnloadX(int x) {
		_port.setUnloadX(x);
	}

	public void setUnloadY(int y) {
		_port.setUnloadY(y);
	}

	public void setTruckTop(int num) {
		_port.setTruckTop(num);
	}

	public void mark(int x, int y) {
		_port.mark(x, y);
	}

	public void move() {
		_port.move();
	}

	public void setAllFramesToBlack(int x, int y) {
		_port.setAllFramesToBlack(x, y);
	}

	public void restart() {
		_port.restart();

	}
}
