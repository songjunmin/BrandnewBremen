using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class GameManager : MonoBehaviour
{
    public static GameManager instance;

    public GameObject player;

    public int gold;
    public float interactionRange;
    public bool[] isOpenWeapon;
    public float[] abnormalStatusTime;

    // ������Ʈ�� �ߺ����� �������� �ʰ� ���� / �ܺο��� ���� �����ϰ� ����
    private void Awake()
    {
        if (instance == null)
        {
            instance = this;    // �ν��Ͻ��� �� �Ҵ�

            DontDestroyOnLoad(gameObject);
        }

        else if (instance != this)
        {
            Destroy(gameObject);
        }

    }

    private void Update()
    {
        AbnormalStatusTimeManager();
    }

    // �����̻� ���� �ð� ����
    void AbnormalStatusTimeManager()
    {
        for (int i = 0; i < abnormalStatusTime.Length; i++)
        {
            if ( abnormalStatusTime[i] > 0 )
            {
                abnormalStatusTime[i] -= Time.deltaTime;

                if (abnormalStatusTime[i] <= 0)
                {
                    // �����ٰ� ȣ��
                }
            }
        }
    }

    // �����̻� ����� ��, ���� �޾ƿ���
    public void GetAbnormalStatus(int abnormalType , float time)
    {
        abnormalStatusTime[abnormalType] = time;
    }

    // ���� ����
    public void ExitGame()
    {
#if UNITY_EDITOR
        UnityEditor.EditorApplication.isPlaying = false;
#else
        Application.Quit(); // ���ø����̼� ����
#endif
    }
}
