using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class CameraOneController : MonoBehaviour
{
	// Start is called before the first frame update
	public Transform target;
	public Vector3 offset;

	void Update()
	{
		Vector3 CamPosition = target.position + offset;
		transform.position = CamPosition;
		transform.LookAt(target); // Target ist der Ball 
	}
}
