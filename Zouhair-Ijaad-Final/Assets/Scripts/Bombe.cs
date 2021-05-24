using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Bombe : MonoBehaviour
{
    public GameObject bombe;

    private void OnCollisionEnter(Collision other)
    {
        if(other.gameObject.CompareTag("ballTag")){
            bombe.SetActive(true);
        }
    }

    void OnCollisionExit(Collision other)
    {
        bombe.SetActive(false);
    }
    
}
