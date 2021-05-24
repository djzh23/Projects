	using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class TurmGegner : MonoBehaviour
{
	public Transform goal;
	public GameObject kugel;
	public float timestart;
	public float timestop;
	public GameObject target;

	void Start()
	{
		transform.LookAt(target.transform.position);
		timestop = timestart;
	}

	void Update()
	{
		transform.LookAt(target.transform.position);
		if (timestop <= 0)
		{
			Instantiate(kugel, transform.position, transform.rotation);
			timestop = timestart;
		}
		else
		{
			timestop -= Time.deltaTime;
		}
	}
}