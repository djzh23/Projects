using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class EnableDisable: MonoBehaviour {
	private GameObject targetObject;

	public void DisableObject() {
		if (targetObject == null) targetObject = GameObject.FindWithTag("endCircle");
		if (targetObject != null) targetObject.SetActive(false);
	}

	public void EnableObject() {
		if (targetObject != null) targetObject.SetActive(true);
	}

	public void ToggleObject() {
		if (targetObject == null) targetObject = GameObject.FindWithTag("endCircle");

		if (targetObject == null) return;

		if (targetObject.activeSelf) DisableObject();
		else EnableObject();
	}
}