using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class sizenpos : MonoBehaviour
{
    public float shrinktimer;
    public Transform targetcircle;
    private static sizenpos instance;
    public Transform innercircle;
    public Transform outercircle;
    public Vector3 circleSize;
    public Vector3 circlePosition;
    private Vector3 targetsize;
    private Vector3 targetpos;
    private float changespeed;

    public void Awake()
    {
        instance = this;
        outercircle = transform.Find("outercircle");
        innercircle = transform.Find("innercircle");

        setSize(new Vector3(0,0), new Vector3(200,200));
        changespeed = 20f;

        settargetcirclensizepos(new Vector3(0, 0), new Vector3(160, 160), 5f);
    }

    public void settargetcirclensizepos(Vector3 pos, Vector3 size, float shrinktimer)
    {
        this.shrinktimer = shrinktimer;
        targetcircle.position = pos;
        targetcircle.localScale = size;

        targetpos = pos;
        targetsize = size;
    }

    public void setSize(Vector3 position, Vector3 size)
    {
        circlePosition = position;
        circleSize = size;
        transform.position = position;
        outercircle.localScale = size;
        innercircle.localScale = size;
    }

    private void Update()
    {
        shrinktimer -= Time.deltaTime;

        if (shrinktimer < 0)
        {
            Vector3 sizeChange = (targetsize - circleSize).normalized;
            Vector3 newcircleSize = circleSize + sizeChange * Time.deltaTime * changespeed;

            Vector3 move = (targetpos - circlePosition).normalized;
            Vector3 newpos = circlePosition + move * Time.deltaTime * changespeed;
            setSize(newpos, newcircleSize);
            float distest = .1f;
            if(Vector3.Distance(newcircleSize, targetsize) < distest && Vector3.Distance(newpos, targetpos) < distest)
            {
                generateRandom();
            }
        }
    }

    public void generateRandom()
    {
        float shrinksamount = Random.Range(3f, 12f);
        Vector3 generatednewsize = circleSize - new Vector3(shrinksamount, shrinksamount) * 2f;
        if (generatednewsize.x < 20f) generatednewsize = Vector3.one * 20f;
        Vector3 generatednewpos = circlePosition + new Vector3(Random.Range(-shrinksamount, shrinksamount), Random.Range(-shrinksamount,shrinksamount));
        float randomshrinktime = Random.Range(1f, 6f);
        settargetcirclensizepos(generatednewpos, generatednewsize, randomshrinktime);
    }

    public bool isOutside(Vector3 position)
    {
        return Vector3.Distance(position, circlePosition) > circleSize.x * 0.5f;
    }

    public static bool stat(Vector3 position)
    {
        return instance.isOutside(position);
    }

}
