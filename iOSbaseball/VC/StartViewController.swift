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
            initLifeLabel()
        } catch {
            print("에러 발생: \(error)")
        }
        
    }
    
    private func initLifeCount() throws {
        lifeCount = try LifeCount()
    }

    private func initLifeLabel() {
        lifeLabel.text = String(lifeCount.lifes)
    }
    
    @IBAction func btnMinus(_ sender: Any) {
        if lifeCount.decrease() { initLifeLabel() }
    }
    
    @IBAction func btnPlus(_ sender: Any) {
        if lifeCount.increase() { initLifeLabel() }
    }
    
    @IBAction func btnStart(_ sender: Any) {
        
        let storyboard = UIStoryboard(name: "MainView", bundle: nil)
        let vc = storyboard.instantiateViewController(withIdentifier: "MainViewController") as! MainViewController
        
        // 데이터 넘겨주기
        vc.lifeCount = lifeCount
        
        // nav 컨트롤러
        let navController = UINavigationController(rootViewController: vc)
        
        navController.modalPresentationStyle = .fullScreen
        present(navController, animated: true)
    }
}

