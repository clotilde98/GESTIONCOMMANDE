package viewPackage;

public class ImageChangeThread extends Thread {

        private Welcome welcomePanel;
        private String[] imagePaths;
        private boolean running;
        private int currentIndex;

        public ImageChangeThread(Welcome welcomePanel, String[] imagePaths) {
            this.welcomePanel = welcomePanel;
            this.imagePaths = imagePaths;
            this.running = true;
            this.currentIndex = 0;
        }

        public void stopRunning() {
            running = false;
        }

        @Override
        public void run() {
            while (running) {
                welcomePanel.displayImage(imagePaths[currentIndex]);
                currentIndex = (currentIndex + 1) % imagePaths.length;
                try {
                    Thread.sleep(5000); // Wait for 5 seconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
}
