using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Schalter : MonoBehaviour
{

GameObject CircleEndElement;
GameObject piram;
 void Start()
 {
    CircleEndElement = GameObject.FindGameObjectWithTag("endCircleTag");
    GameObject.Find("Circle").SetActive(false);
    piram = GameObject.Find("Helper");
      
 }

    private void OnCollisionEnter(Collision other){
        if(other.gameObject.CompareTag("ballTag")){
            CircleEndElement.SetActive(true);
            piram.transform.GetComponent<Renderer>().material.color = Color.green *10;
        }
    }
        
    
}
