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

    // 오브젝트가 중복으로 생성되지 않게 만듦 / 외부에서 접근 용이하게 생성
    private void Awake()
    {
        if (instance == null)
        {
            instance = this;    // 인스턴스에 나 할당

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

    // 상태이상 남은 시간 관리
    void AbnormalStatusTimeManager()
    {
        for (int i = 0; i < abnormalStatusTime.Length; i++)
        {
            if ( abnormalStatusTime[i] > 0 )
            {
                abnormalStatusTime[i] -= Time.deltaTime;

                if (abnormalStatusTime[i] <= 0)
                {
                    // 끝났다고 호출
                }
            }
        }
    }

    // 상태이상 결렸을 때, 정보 받아오기
    public void GetAbnormalStatus(int abnormalType , float time)
    {
        abnormalStatusTime[abnormalType] = time;
    }

    // 게임 종료
    public void ExitGame()
    {
#if UNITY_EDITOR
        UnityEditor.EditorApplication.isPlaying = false;
#else
        Application.Quit(); // 어플리케이션 종료
#endif
    }
}
