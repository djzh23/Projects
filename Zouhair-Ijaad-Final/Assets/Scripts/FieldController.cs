using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class FieldController : MonoBehaviour
{

    public GameManager gameManager;

    public string valueName; // hier wird die Name der (Field) eingertagen

    Text textComp;

    // Start is called before the first frame update
    void Start()
    {
        textComp = GetComponent<Text>();
        textComp.text = gameManager.GetValue(valueName).ToString();
        gameManager.valueChanged.AddListener(UpdateTextValue);
    }

    void UpdateTextValue(string name, int value){
        if(name == valueName){
            textComp.text = value.ToString();
        }
    }
}
