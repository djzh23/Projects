using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class BeweglicherGegner : MonoBehaviour
    {
    private Vector3 startposition;
    public float delta = 1.5f;
    public float speed = 2.0f;

    void Start(){
        startposition = transform.position;
    }
    void Update(){
        Vector3 f = startposition;
        f.x += delta * Mathf.Sin(Time.time * speed);
        transform.position = f;
    }

}
