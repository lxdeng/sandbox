provider "google" {
  credentials = "${file("terraform-account.json")}"
  project = "sandbox-20180205"
  region = "us-central1"
}
