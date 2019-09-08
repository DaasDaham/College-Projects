using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class collide1 : MonoBehaviour
{
   // public CharacterController2D controller;

    float horizontalMove = 0f;

    [SerializeField]
    Transform rotationCenter;

    [SerializeField]
    float rotationRadius = 2f, angularSpeed = 2f;

    float Posx, Posy, angle = 0f;
    // Start is called before the first frame update
    // Update is called once per frame
    void Update()
    {
        Posx = rotationCenter.position.x + Mathf.Cos(angle) * rotationRadius;
        Posy = rotationCenter.position.y + Mathf.Sin(angle) * rotationRadius;
        transform.position = new Vector2(Posx, Posy);
        angle = angle + Time.deltaTime * angularSpeed;

        if (angle >= 360f)
            angle = 0f;

        horizontalMove = Input.GetAxisRaw("Horizontal");
        Debug.Log(horizontalMove);
        if(horizontalMove == 1)
        {
            rotationRadius += 0.05f;
        }
        else if(horizontalMove == -1)
        {
            rotationRadius -= 0.05f;
        }
    }

    /*void FixedUpdate()
    {
        controller.Move(horizontalMove);
        Debug.Log(controller.Move(horizontalMove));
    }*/
}
