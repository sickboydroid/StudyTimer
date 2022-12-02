package com.tangledbytes.studytimer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class TimerController {

	StudyTimer timer;
	@FXML
	private Label labelTime;

	public void initialize() {
		timer = new StudyTimer(labelTime);
	}

	@FXML
	void onClickResetTimer(ActionEvent event) {
		timer.resetTimer(5 * 60 * 1000, true, runnableFiveMinuteTimerCompletion);
	}

	@FXML
	void onClickClose(ActionEvent event) {
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.close();
	}


	Runnable runnableFiveMinuteTimerCompletion = new Runnable() {
		@Override
		public void run() {
			timer.resetTimer(5 * 1000, false, runnableTenSecondTimerCompletion);
		}
	};

	Runnable runnableTenSecondTimerCompletion = new Runnable() {
		@Override
		public void run() {
			timer.resetTimer(5*60 * 1000, true, runnableFiveMinuteTimerCompletion);
		}
	};


}
