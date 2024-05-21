//
//  ViewController.swift
//  iOSbaseball
//
//  Created by KimMinSeok on 5/18/24.
//

import UIKit

enum RestartError: Error {
    case IllegalArgumentException
}

class StartViewController: UIViewController {

    @IBOutlet weak var lifeLabel: UILabel!
    
    var lifeCount: LifeCount! // 옵셔널 제거
    
    override func viewDidLoad() {
        super.viewDidLoad()
        do {
            try initLifeCount() // lifeCount 초기화 추가
            try initLifeLabel()
        } catch {
            print("에러 발생: \(error)")
        }
        
    }
    
    private func initLifeCount() throws {
        lifeCount = try LifeCount()
    }

    private func initLifeLabel() throws {
        lifeLabel.text = String(lifeCount.lifes)
    }
    
    @IBAction func btnMinus(_ sender: Any) {
        if lifeCount.decrease() {
            lifeLabel.text = String(lifeCount.lifes)
        }
    }
    
    @IBAction func btnPlus(_ sender: Any) {
        if lifeCount.increase() {
            lifeLabel.text = String(lifeCount.lifes)
        }
    }
    @IBAction func btnStart(_ sender: Any) {
        
        // 띄어야할 부분 : FrameworkDetailViewController
        let storyboard = UIStoryboard(name: "MainView", bundle: nil)
        let vc = storyboard.instantiateViewController(withIdentifier: "MainViewController") as! MainViewController
        
        let navController = UINavigationController(rootViewController: vc) 
        // 데이터 넘겨주기
        navController.modalPresentationStyle = .fullScreen
        present(navController, animated: true)
    }
}

