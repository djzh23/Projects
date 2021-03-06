using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class moveCamera: MonoBehaviour {

	public Transform lookAt;
	public Transform camTransform;
	private Camera myCam;

	private float distance = 5.0f;
	private float currentX = 0.0f;
	private float currentY = 0.0f;

	private const float Y_ANGLE_MIN = 0.0f;
	private const float Y_ANGLE_MAX = 30.0f;

	private void Awake() {

		camTransform = transform;
		myCam = GameObject.Find("MoveCamera").GetComponent < Camera > ();
		lookAt = GameObject.Find("Ball").transform;

	}

	private void Update() {

		currentX += Input.GetAxis("Mouse X");
		currentY += Input.GetAxis("Mouse Y");

		currentY = Mathf.Clamp(currentY, Y_ANGLE_MIN, Y_ANGLE_MAX);
	}

	void LateUpdate() {
		Vector3 dir = new Vector3(0, 0, -distance);
		Quaternion rotation = Quaternion.Euler(currentY, currentX, 0);
		camTransform.position = lookAt.position + rotation * dir;
		camTransform.LookAt(lookAt.position);
	}

}